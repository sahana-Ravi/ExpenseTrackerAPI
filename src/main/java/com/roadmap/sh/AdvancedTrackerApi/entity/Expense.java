package com.roadmap.sh.AdvancedTrackerApi.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Entity
@Data
@Table(name="expenses")
public class Expense extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private Double cost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") //Many expenses can have same UserId, create a new column
    //user_id and User.id in this column
    private User user;


}



//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "user_id") //Many expenses can have same UserId, create a new column
////user_id and User.id in this column
//private User user;
//
//i really dont understand, if I am creating a new column usre_id what is this User user??
//
//This is the exact point where most people get confused. You're mixing up Java objects with database columns. They are related, but they are not the same thing.
//
//Let's separate them.
//
//In Java
//
//You wrote:
//
//private User user;
//
//Ask yourself:
//
//What type is this variable?
//
//It's a User object.
//
//Just like you can have:
//
//private String description;
//private Double cost;
//
//you can also have:
//
//private User user;
//
//So in Java, an Expense object literally contains a reference to another object.
//
//Expense Object
//----------------------
//id = 1
//description = Lunch
//        cost = 250
//user --------> User Object
//
//Notice it's pointing to an actual User object.
//
//In the Database
//
//Databases cannot store Java objects.
//
//SQL doesn't know what a User object is.
//
//So Hibernate converts
//
//private User user;
//
//into
//
//        user_id
//
//because that's how relational databases represent relationships.
//
//So your table becomes
//
//id	description	cost	user_id
//1	Lunch	250	5
//Where does @JoinColumn come in?
//
//This annotation
//
//@JoinColumn(name = "user_id")
//
//is Hibernate's instruction:
//
//        "When you store the User object, don't actually store the object. Store its ID in a column called user_id."
//
//So
//
//expense.setUser(user);
//
//Suppose
//
//user.getId()
//
//returns
//
//5
//
//Hibernate automatically saves
//
//id	description	cost	user_id
//1	Lunch	250	5
//
//You never write
//
//expense.setUserId(5);
//
//Hibernate does that for you.