package com.gcu.store.controllers;

import com.gcu.store.business.ItemBusinessInterface;
import com.gcu.store.models.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/blog")
public class ItemController {

    @Autowired
    private ItemBusinessInterface itemService;

    @Autowired
    HttpSession session;

    @GetMapping("/")
    public String blogs(Model model)
    {
        // If user securely logged in, add to session data.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            if(null == session.getAttribute("user"))
            {
                session.setAttribute("user", currentUserName);
            }
        }

        List<ItemModel> itemList = itemService.getItem();

        model.addAttribute("title", "Items");
        model.addAttribute("blogList", itemList);

        return "blogs";
    }

    @GetMapping("/createBlog")
    public String addBlogs(Model model)
    {

        model.addAttribute("title", "Add New Item");
        model.addAttribute("blogModel", new ItemModel());

        return "createBlog";
    }

    @GetMapping("/displayBlog/{id}")
    public String displayBlog(@PathVariable("id") int id, Model model)
    {

        ItemModel item = itemService.getItemById(id);


        model.addAttribute("title", "Display Blog");
        model.addAttribute("blogModel", item);

        return "displayBlog";
    }

    @PostMapping("/doAddItem")
    public String doAddItem(@Valid ItemModel itemModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Add Item Form");
            return "createBlog";
        }

        itemService.addItem(itemModel);

        List<ItemModel> itemList = itemService.getItem();

        model.addAttribute("title", "Item");
        model.addAttribute("itemList", itemList);

        return "blogs";
    }

    @PostMapping("/doDeleteBlog/{id}")
    public String doDeleteBlog(@PathVariable int id)
    {
        ItemModel blog = itemService.getItemById(id);

        itemService.deleteItem(blog);

        return "redirect:/blogs/";
    }

    @PostMapping("/updateBlog/{id}")
    public String updateBlog(@PathVariable int id, Model model) {

        ItemModel blog = itemService.getItemById(id);

        model.addAttribute("blogModel", blog);

        return "updateBlog";
    }

    @PostMapping("/doUpdateBlog")
    public String doUpdateBlog(@Valid ItemModel blogModel, BindingResult bindingResult, Model model)
    {
        // Check form data for errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Edit Blog Form");
            return "createBlog";
        }

        itemService.updateItem(blogModel);

        // Get list of all coffee products
        List<ItemModel> blogList = itemService.getItem();

        model.addAttribute("title", "Blog");
        model.addAttribute("blogList", blogList);

        return "blogs";
    }





}
