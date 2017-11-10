package com.imooc.web.rest;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Shinelon
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static void error(ObjectError error) {
        System.out.println(error.getDefaultMessage());
    }

    @JsonView(User.UserSimpleView.class)
    @PostMapping
    public User create(@Valid @RequestBody User user) {
        user.setId("1");

        System.out.println(user);
        return user;
    }

    @JsonView(User.UserSimpleView.class)
    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors, @PathVariable String id) {

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(UserController::error);
        }

        user.setId("1");

        System.out.println(user);
        return user;
    }


    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault Pageable pageAble) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(ReflectionToStringBuilder.toString(pageAble, ToStringStyle.MULTI_LINE_STYLE));

        List<User> users = new ArrayList<>(3);
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @JsonView(User.UserDetailView.class)
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable String id) {
//        throw new UserNotFountException(id);
        User user = new User();
        user.setUsername("tom");
        System.out.println("调用 getInfo服务");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {

    }

    @GetMapping("/me")
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
