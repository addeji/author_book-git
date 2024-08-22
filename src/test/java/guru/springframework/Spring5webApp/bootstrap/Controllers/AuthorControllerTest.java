package guru.springframework.Spring5webApp.bootstrap.Controllers;

import guru.springframework.Spring5webApp.services.Impl.AuthorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = AuthorController.class)
class AuthorControllerTest {

    @MockBean
    AuthorServiceImpl authorService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AuthorController authorController;

    @Test
    void getAllAuthors() throws Exception {

        mockMvc.perform(get("/authors" + authorController.getAllAuthors()).accept(MediaType.APPLICATION_JSON
        )).andExpect(status().isOk());

    }
}