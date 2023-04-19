//package trevo.maquinas.api.product;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//import trevo.maquinas.api.ApiApplication;
//import trevo.maquinas.api.dto.CategoryEnum;
//import trevo.maquinas.api.dto.StatusEnum;
//import trevo.maquinas.api.model.Product;
//import trevo.maquinas.api.repository.ProductRepository;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//@SpringBootTest(classes = ApiApplication.class)
//@AutoConfigureMockMvc
//public class ProductRepositoryTest {
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Test
//    public void whenCreate() {
//        Product product = new Product();
//        product.setName("teste");
//        product.setDescription("Teste");
//        product.setStatus(StatusEnum.DISPONIVEL);
//        product.setCategory(CategoryEnum.COMBUSTIVEL);
//        Product save = productRepository.save(product);
//        Assertions.assertThat(save.getId()).isNotNull();
//        assertThat(product.getId()).isNotNull();
//        assertThat(product.getName()).isEqualTo("Teste1");
//        assertThat(product.getDescription()).isEqualTo("Esse produto é um pulverizador");
//        assertThat(product.getCategory()).isEqualTo(CategoryEnum.COMBUSTIVEL);
//        assertThat(product.getPrice()).isEqualTo(1354.5);
//        assertThat(product.getStatus()).isEqualTo(StatusEnum.DISPONIVEL);
//    }
//}
