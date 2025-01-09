//package com.example.onlineShop.config;
//
//import com.example.onlineShop.constants.Path;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.convention.MatchingStrategies;
//import org.modelmapper.spi.MatchingStrategy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class MvcConfig implements WebMvcConfigurer {
//
//    @Bean
//    public RestTemplate getRestTemplate(){
//        return new RestTemplate();
//    }
//
//    @Bean
//    public ModelMapper modelMapper(){
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        return mapper;
//    }
//
//    public void addViewControllers(ViewControllerRegistry controllerRegistry){
//        controllerRegistry.addViewController(Path.LOGIN).setViewName("login");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("classpath:/uploads/");
//        registry.addResourceHandler("/static/**")
//                .addResourceLocations("classpath:/static/");
//    }
//}
