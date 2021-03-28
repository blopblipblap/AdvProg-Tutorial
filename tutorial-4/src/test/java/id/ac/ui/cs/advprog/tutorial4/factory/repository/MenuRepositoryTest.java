package id.ac.ui.cs.advprog.tutorial4.factory.repository;

import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.InuzumaRamen;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.LiyuanSoba;
import id.ac.ui.cs.advprog.tutorial4.factory.core.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class MenuRepositoryTest {
    private MenuRepository menuRepository;

    @Mock
    private List<Menu> menus;

    private Menu sampleMenu;

    @BeforeEach
    public void setUp() {
        menuRepository = new MenuRepository();
        menus = new ArrayList<>();
        sampleMenu = new InuzumaRamen("ramen lezatt");
        menus.add(sampleMenu);
    }

    @Test
    public void testGetMenusReturnsMenuList() {
        menuRepository.add(sampleMenu);
        List<Menu> acquiredMenus = menuRepository.getMenus();

        assertThat(acquiredMenus).isEqualTo(menus);
    }

    @Test
    public void testAddMenuShouldAddToMenuList() {
        menuRepository.add(sampleMenu);
        Menu sampleMenu2 = new LiyuanSoba("soba lezatt");
        menuRepository.add(sampleMenu2);
        List<Menu> acquiredMenus = menuRepository.getMenus();

        menus.add(sampleMenu2);

        assertThat(acquiredMenus).isEqualTo(menus);
    }
}
