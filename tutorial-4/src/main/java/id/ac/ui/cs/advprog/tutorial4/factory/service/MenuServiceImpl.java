package id.ac.ui.cs.advprog.tutorial4.factory.service;

import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.InuzumaRamenFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.LiyuanSobaFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.MondoUdonFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.ingridients.SnevnezhaShiratakiFactory;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.SnevnezhaShirataki;
import id.ac.ui.cs.advprog.tutorial4.factory.repository.MenuRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class    MenuServiceImpl implements MenuService {
    private MenuRepository repo;

    public MenuServiceImpl(MenuRepository repo){
        this.repo = repo;
        initRepo();
    }

    public MenuServiceImpl(){
        this(new MenuRepository());
    }

    public Menu createMenu(String name, String type){
        Menu res = null;
        if(type.equals("LiyuanSoba")){
            res = new LiyuanSoba(name);
        } else if(type.equals("InuzumaRamen")){
            res = new InuzumaRamen(name);
        } else if(type.equals("MondoUdon")) {
            res = new MondoUdon(name);
        } else {
            res = new SnevnezhaShirataki(name);
        }

        return repo.add(res);
    }

    public List<Menu> getMenus(){
        return repo.getMenus();
    }

    private void initRepo(){
        createMenu("WanPlus Beef Mushroom Soba", "LiyuanSoba");
        createMenu("Bakufu Spicy Pork Ramen", "InuzumaRamen");
        createMenu("Good Hunter Cheese Chicken Udon", "MondoUdon");
        createMenu("Morepeko Flower Fish Shirataki", "SnevnezhaShirataki");
    }
}