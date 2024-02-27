package com.example.gameshop.web.controllers;

import com.example.gameshop.models.Game;
import com.example.gameshop.models.Order;
import com.example.gameshop.models.User;
import com.example.gameshop.repository.GameRepository;
import com.example.gameshop.repository.OrderRepository;
import com.example.gameshop.repository.UserRepository;
import com.example.gameshop.services.Impl.LoginService;
import com.example.gameshop.services.Impl.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Security;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    LoginService loginService;
    OrderRepository orderRepository;
    GameRepository gameRepository;
    OrderService orderService;
    UserRepository userRepository;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @GetMapping("/cart")
    public String getShopingCart(Model model){
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(loggedUser.getUsername());
        Optional<Order> order = orderRepository.findByUserAndPaymentStatusIsFalse(user);
        if (order.isPresent()){
            model.addAttribute("order", order.get());
        }
        if (order.isPresent() && order.get().getGames().isEmpty()){
            model.addAttribute("errorMessage", "The order does not contain any games.");
        }
        if (!order.isPresent()){
            model.addAttribute("errorMessage", "You need to create a order first by adding games to your cart!");
        }
        model.addAttribute("bodyContent", "shopping_cart");
        return "landingpage";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @PostMapping("/create/{id}")
    public String createOrder(@PathVariable Integer id, Model model){
        Game g = gameRepository.findById(Long.valueOf(id)).get();
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(loggedUser.getUsername());
        Optional<Order> order = orderRepository.findByUserAndPaymentStatusIsFalse(user);
        if (order.isPresent()){
            orderService.updateOrder(order.get(), g);
        }else {
            orderRepository.save(new Order(
                    LocalDate.now(),
                    g.getPrice(),
                    false,
                    user,
                    Set.of(g)
            ));
        }
        return "redirect:/order/cart";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CUSTOMER')")
    @PostMapping("/clear")
    public String clearOrder(){
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(loggedUser.getUsername());
        Optional<Order> order = orderRepository.findByUserAndPaymentStatusIsFalse(user);
        if (order.isPresent()){
            orderService.clearGames(order.get());
        }
        return "redirect:/order/cart";
    }

    @PostMapping("/pay")
    public String confirmOrder(){
        UserDetails loggedUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(loggedUser.getUsername());
        Optional<Order> order = orderRepository.findByUserAndPaymentStatusIsFalse(user);
        if (order.isPresent()){
            orderService.confirmPayout(order.get());
        }
        return "redirect:/game/listPagination";
    }

}
