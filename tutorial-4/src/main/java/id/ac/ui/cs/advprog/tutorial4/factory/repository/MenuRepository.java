package id.ac.ui.cs.advprog.tutorial4.factory.repository;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class MenuRepository {
    private List<Menu> list;

    public MenuRepository(){
        this.list = new ArrayList<>();
    }

    public List<Menu> getMenus(){
        return list;
    }

    public Menu add(Menu menu){
        list.add(menu);
        return menu;
    }
}