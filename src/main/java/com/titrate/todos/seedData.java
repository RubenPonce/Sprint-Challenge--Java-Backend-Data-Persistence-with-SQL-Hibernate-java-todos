package com.titrate.todos;

import com.titrate.todos.model.Role;
import com.titrate.todos.model.Todos;
import com.titrate.todos.model.User;
import com.titrate.todos.model.UserRoles;
import com.titrate.todos.repository.RoleRepository;
import com.titrate.todos.repository.TodosRepository;
import com.titrate.todos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Component
public class seedData implements CommandLineRunner
{
    RoleRepository rolerepos;
    UserRepository userrepos;
    TodosRepository todorepos;

    public seedData(RoleRepository rolerepos, UserRepository userrepos, TodosRepository todorepos)
    {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception
    {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        ArrayList<UserRoles> admins = new ArrayList<>();
        admins.add(new UserRoles(new User(), r1));
        admins.add(new UserRoles(new User(), r2));

        ArrayList<UserRoles> users = new ArrayList<>();
        users.add(new UserRoles(new User(), r2));

        rolerepos.save(r1);
        rolerepos.save(r2);

        User u1 = new User("barbar", "ILuvM4th!", users);
        User u2 = new User("admin", "password", admins);


        u1.getTodos().add(new Todos("Finish java-orders-swagger", "2019-01-13 04:04:04", u1));
        u1.getTodos().add(new Todos("Feed the turtles", "2019-03-01 04:04:04", u1));
        u1.getTodos().add(new Todos("Complete the sprint challenge", "2019-02-22 04:04:04", u1));

        u2.getTodos().add(new Todos("Walk the dogs", "2019-01-17 04:04:04", u2));
        u2.getTodos().add(new Todos("End the 2020 Recession", "2002-08-03 04:04:04", u2));
        u2.getTodos().add(new Todos("provide feedback to my instructor", "2019-02-23 01:03:04", u2));

        userrepos.save(u1);
        userrepos.save(u2);

    }
}
