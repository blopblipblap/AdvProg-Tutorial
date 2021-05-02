package id.ac.ui.cs.advprog.tutorial4.factory.service;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.MondoUdon;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.SnevnezhaShirataki;
import id.ac.ui.cs.advprog.tutorial4.factory.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MenuServiceTest {
    @Mock
    private MenuRepository menuRepository;

    @InjectMocks
    private MenuServiceImpl menuService;

    @Test
    public void testInit() {
        menuService = new MenuServiceImpl();
        verify(menuRepository, atLeast(4)).add(any(Menu.class));
    }

    @Test
    public void testCreateMenuMethod() {
        menuService.createMenu("udon lezatt", "MondoUdon");
        verify(menuRepository, atLeast(1)).add(any(MondoUdon.class));
    }

    @Test
    public void testGetMenusMethod() {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new LiyuanSoba("soba lezatt"));

        MenuService menuSpy = spy(menuService);

        when(menuSpy.getMenus())
                .thenReturn(menuList);

        Iterable<Menu> calledMenu = menuSpy.getMenus();

        assertThat(calledMenu).isEqualTo(menuList);

    }
}
