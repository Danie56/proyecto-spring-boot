package com.example.proyecto_spring_boot.product.aplication.scheduling;

import com.example.proyecto_spring_boot.product.domain.entity.Product;
import com.example.proyecto_spring_boot.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@RequiredArgsConstructor
@Slf4j
public class FixProductIdSchedule {


//    @Scheduled(fixedRate = 5000)
//    public void fixProductId() {
//        log.info("fixing product id");
//        List<Product> products = productRepository.getAll();
//        if (products.size() == previousSize) {
//            log.info("The IDs are already organized.");
//            return;
//
//        }
//
//
//        AtomicLong counter = new AtomicLong(1);
//        products.stream()
//                .sorted(Comparator.comparing(Product::getId))
//                .forEach(p -> p.setId(counter.getAndIncrement()));
//
//        products.forEach(productRepository::upsert);
//
//        previousSize = products.size();
//
//        log.info("finish fixing product id");
//
//
//    }
}
