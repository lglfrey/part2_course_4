package com.example.demo.Controllers;

import com.example.demo.dao.GenericDAO;
import com.example.demo.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    private final GenericDAO<User> userGenericDAO;
    private final GenericDAO<Comment> commentGenericDAO;
    private final GenericDAO<Friendship> friendshipGenericDAO;
    private final GenericDAO<Message> messageGenericDAO;
    private final GenericDAO<Post> postGenericDAO;
    private boolean True = false;

    @Autowired
    public MainController(
            GenericDAO<User> userGenericDAO,
            GenericDAO<Comment> commentGenericDAO,
            GenericDAO<Friendship> friendshipGenericDAO,
            GenericDAO<Message> messageGenericDAO,
            GenericDAO<Post> postGenericDAO
    ) {
        this.userGenericDAO = userGenericDAO;
        this.commentGenericDAO = commentGenericDAO;
        this.friendshipGenericDAO = friendshipGenericDAO;
        this.messageGenericDAO = messageGenericDAO;
        this.postGenericDAO = postGenericDAO;
    }

    @GetMapping()
    public String index(Model model) {
        if (!True)
        {
            userGenericDAO.create(
                    new User(
                            userGenericDAO.NEXT_ID,
                            "oleg",
                            "olp201915@gmail.com",
                            "olp102405"
                    )
            );
            userGenericDAO.create(
                    new User(
                            userGenericDAO.NEXT_ID,
                            "oleg111",
                            "olp15@gmail.com",
                            "qwerty"
                    )
            );
            commentGenericDAO.create(
                    new Comment(
                            commentGenericDAO.NEXT_ID,
                            "test",
                            "https://gas-kvas.com/en/uploads/posts/2022-08/1661325241_5-gas-kvas-com-p-beautiful-photos-of-chelyabinsk-city-from-6.jpg",
                            "3 февраля")
            );
            friendshipGenericDAO.create(
                    new Friendship(
                            friendshipGenericDAO.NEXT_ID,
                            "test",
                            "https://klike.net/uploads/posts/2023-01/1675172315_3-60.jpg",
                            "Отправлено")
            );
            messageGenericDAO.create(
                    new Message(
                            friendshipGenericDAO.NEXT_ID,
                            "text",
                            "https://images6.alphacoders.com/351/351875.jpg",
                            "5 march")
            );
            postGenericDAO.create(
                    new Post(
                            postGenericDAO.NEXT_ID,
                            "new day",
                            "https://s1.1zoom.ru/b5050/789/380341-svetik_3840x2400.jpg",
                            "5 may")
            );
            True = true;
        }

        model.addAttribute("users", userGenericDAO.getAll());
        model.addAttribute("comments", commentGenericDAO.getAll());
        model.addAttribute("friends", friendshipGenericDAO.getAll());
        model.addAttribute("messages", messageGenericDAO.getAll());
        model.addAttribute("posts", messageGenericDAO.getAll());

        return "index";
    }

    @GetMapping("/{models}/{id}")
    public String show(
            @PathVariable("models") String models,
            @PathVariable("id") int id,
            Model model) {
        Object entity = null;

        switch (models.toLowerCase()) {
            case "user" -> entity = userGenericDAO.show(id);
            case "comment" -> entity = commentGenericDAO.show(id);
            case "friendship" -> entity = friendshipGenericDAO.show(id);
            case "message" -> entity = messageGenericDAO.show(id);
            case "post" -> entity = postGenericDAO.show(id);
            default -> {
            }
        }

        if (entity != null) {
            model.addAttribute("entity", entity);
            model.addAttribute("models", models);
        }

        return "show";
    }

    @GetMapping("/new/{modelName}")
    public String createNewModel(@PathVariable("modelName") String modelName, Model model) {
        Object modelObject = null;

        switch (modelName.toLowerCase()) {
            case "user" -> modelObject = new User();
            case "comment" -> modelObject = new Comment();
            case "friendship" -> modelObject = new Friendship();
            case "message" -> modelObject = new Message();
            case "post" -> modelObject = new Post();
            default -> {
            }
        }
        model.addAttribute("modelName", modelName);
        model.addAttribute("modelObject", modelObject);

        return "new";
    }
    @PostMapping("/add")
    public String addModelObject(
            @ModelAttribute("modelObject") Object modelObject,
            @ModelAttribute("modelName") String modelName,
            @RequestParam(name = "Value1Name", defaultValue = "Default1Value") String Value1,
            @RequestParam(name = "Value2Name", defaultValue = "Default2Value") String Value2,
            @RequestParam(name = "Value3Name", defaultValue = "Default3Value") String Value3
    ) {

        switch (modelName.toLowerCase()) {
            case "user" -> userGenericDAO.create(new User(0,Value1,Value2,Value3));
            case "comment" -> commentGenericDAO.create(new Comment(0,Value1,Value2,Value3));
            case "friendship" -> friendshipGenericDAO.create(new Friendship(0,Value1,Value2,Value3));
            case "message" -> messageGenericDAO.create(new Message(0,Value1,Value2,Value3));
            case "post" -> postGenericDAO.create(new Post(0,Value1,Value2,Value3));
            default -> {
                return "redirect:/";
            }
        }

        return "redirect:/new/" + modelName;
    }

    @GetMapping("/{id}/edit")
    public String edit(
            @RequestParam(name = "Value1Name", defaultValue = "Default1Value") String Value1,
            @RequestParam(name = "Value2Name", defaultValue = "Default2Value") String Value2,
            @RequestParam(name = "Value3Name", defaultValue = "Default3Value") String Value3,
            @RequestParam(name = "modelN", defaultValue = "def") String modelName,

            Model model, @PathVariable("id") int id
    ) {
        switch (modelName.toLowerCase()) {
            case "user" -> userGenericDAO.update(id,new User(0,Value1,Value2,Value3));
            case "comment" -> commentGenericDAO.update(id,new Comment(0,Value1,Value2,Value3));
            case "friendship" -> friendshipGenericDAO.update(id,new Friendship(0,Value1,Value2,Value3));
            case "message" -> messageGenericDAO.update(id,new Message(0,Value1,Value2,Value3));
            case "post" -> postGenericDAO.update(id,new Post(0,Value1,Value2,Value3));
            default -> {
                return "redirect:/lll";
            }
        }
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id,
                         @RequestParam(name = "modelN", defaultValue = "def") String modelName
                         ) {
        switch (modelName.toLowerCase()) {
            case "user" -> userGenericDAO.delete(id);
            case "comment" -> commentGenericDAO.delete(id);
            case "friendship" -> friendshipGenericDAO.delete(id);
            case "message" -> messageGenericDAO.delete(id);
            case "post" -> postGenericDAO.delete(id);
            default -> {
                return "redirect:/lll";
            }
        }
        return "redirect:/";
    }
}
