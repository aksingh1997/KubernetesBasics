package com.abhi.Kubernetes;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class BookUtil {
    @Value("${book.maths.name}")
    String mathsBookName;

    @Value("${book.physics.name}")
    String physicsBookName;

    @Value("${book.chemistry.name}")
    String chemistryBookName;

    @Value("${book.maths.price}")
    int mathsBookPrice;

    @Value("${book.physics.price}")
    int physicsBookPrice;

    @Value("${book.chemistry.price}")
    int chemistryBookPrice;

    @Override
    public String toString() {
        return mathsBookName + " :: Rs " + mathsBookPrice + "\n"
                + physicsBookName + " :: Rs " + physicsBookPrice + "\n"
                + chemistryBookName + " :: Rs " + chemistryBookPrice + "\n";
    }
}
