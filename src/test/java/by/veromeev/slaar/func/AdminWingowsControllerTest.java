package by.veromeev.slaar.func;

import by.veromeev.slaar.admin.controller.AdminWindowsController;
import by.veromeev.slaar.dao.ChatWindowDAO;
import by.veromeev.slaar.entity.ChatWindow;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class AdminWingowsControllerTest {

    @MockBean
    ChatWindowDAO windowDAO;

    private List<ChatWindow> chatWindows = Stream.of(
            new ChatWindow("window1", "123456789012345", "123456789012345", "123456789012345", new HashSet<>()),
            new ChatWindow("window2", "123456789012345", "123456789012345", "123456789012345", new HashSet<>())
    ).collect(Collectors.toList());

    @Test
    public void shouldDisplayAllWindows() {
        Model model = new ConcurrentModel();
        Mockito.when(windowDAO.findAll()).thenReturn(chatWindows);
        ModelAndView mv = new ModelAndView();
        AdminWindowsController controller = new AdminWindowsController(windowDAO);
        String viewName = controller.windows(model);
        assertEquals("admin.windows.list", viewName);
        Iterable<ChatWindow> result = (Iterable<ChatWindow>) (((ConcurrentModel) model).get("chatWindows"));
        int length = 0;
        for (ChatWindow chatWindow : result) {
            length++;
        }
        assertEquals(length, chatWindows.size());
    }

}
