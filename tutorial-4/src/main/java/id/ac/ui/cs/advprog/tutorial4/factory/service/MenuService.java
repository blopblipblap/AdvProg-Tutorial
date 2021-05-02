package id.ac.ui.cs.advprog.tutorial4.factory.service;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import java.util.List;

public interface MenuService {
    List<Menu> getMenus();
    Menu createMenu(String name, String type);
}