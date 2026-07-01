package com.example.TikintiMateriallari.services.impls;

import com.example.TikintiMateriallari.dtos.basket.BasketAddDto;
import com.example.TikintiMateriallari.dtos.basket.BasketUserDto;
import com.example.TikintiMateriallari.models.Basket;
import com.example.TikintiMateriallari.models.Product;
import com.example.TikintiMateriallari.models.User;
import com.example.TikintiMateriallari.repositories.BasketRepository;
import com.example.TikintiMateriallari.services.BasketService;
import com.example.TikintiMateriallari.services.ProductService;
import com.example.TikintiMateriallari.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Override
    public List<BasketUserDto> getBasketItems(String email) {
        User user = userService.getUserByEmail(email);
        List<Basket> basketList = user.getBaskets();
        if (!basketList.isEmpty()) {
            return basketList.stream().map(basket -> modelMapper.map(basket, BasketUserDto.class)).toList();
        }
        return List.of();
    }

    @Override
    public void createBasketItem(BasketAddDto basketAddDto, String email) {

        User user = userService.getUserByEmail(email);
        Product product = productService.getProductById(basketAddDto.getProductId());


        Basket findProductBasket = basketRepository.findByProductIdAndUserId(basketAddDto.getProductId() , user.getId());


        if (findProductBasket != null) {
            findProductBasket.setQuantity(findProductBasket.getQuantity() + basketAddDto.getQuantity());
            basketRepository.save(findProductBasket);
            return;

        }


        Basket basket = new Basket();
        basket.setQuantity(basketAddDto.getQuantity());
        basket.setProduct(product);
        basket.setUser(user);
        basketRepository.save(basket);

    }
}
