package com.mongod.mongow9.repository;

import com.mongod.mongow9.model.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, ObjectId> {


    List<Book> findBookByPriceGreaterThan(Double price);

    @Query("{ price: { $gt: ?0 } }")
    List<Book> findBookByPriceGreaterThan2(Double price);

    @Query(value = "{ price: { $gt: ?0 } }", fields = "{ title: 1, price:1 }", sort = "{title:1}")
    List<Book> findBookByPriceGreaterThan3(Double price);

    @Query(value = "{ 'price': { $gt: :#{#priceparam} } }", fields = "{ title: 1, price:1 , _id:0}", sort = "{title:-1}")
    List<Book> findBookByPriceGreaterThan4(Double priceparam);

    @Aggregation({
            "{$match: { price: { $gt: ?0 } } }"
    })
    List<Book> findBookByPriceGreaterThan5(Double price);
}

