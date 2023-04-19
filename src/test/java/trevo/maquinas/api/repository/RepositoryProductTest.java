package trevo.maquinas.api.repository;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(classes = ApiApplication.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//@SpringBootTest(classes = ApiApplication.class)
//@MockitoSettings
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("test")
//@SpringBootTest(classes = ApiApplication.class)
//@AutoConfigureMockMvc
//public class RepositoryProductTest {
//    @Autowired
//    ProductRepository productRepository;
//    @Test
//    public void whenCreateProduct_thenPersistenseData() {
//        Product product = new Product();
//        product.setName("Teste1");
//        product.setDescription("Esse produto é um pulverizador");
//        productRepository.save(product);
//        assertThat(product.getId()).isNotNull();
//        assertThat(product.getName()).isEqualTo("Teste2");
//        assertThat(product.getDescription()).isEqualTo("Esse produto é um pulverizador");
//    }
//
//    @Test
//    public void whenUpdatename_thenPersistenseData() {
//        Product product = new Product(new ProductDadosDTO("Teste1", "Esse produto é um pulverizador", null, null, null));
//        productRepository.save(product);
//        product.setName("Teste5");
//        productRepository.save(product);
//        assertThat(product.getName()).isEqualTo("Teste5");
//    }
//
//    @Test
//    public void whenUpdateDescription_thenPersistenseData() {
//        Product product = new Product(new ProductDadosDTO("Teste2", "Esse produto é um pulverizador", null, null, null));
//        productRepository.save(product);
//        product.setDescription("Esse produto");
//        productRepository.save(product);
//        assertThat(product.getDescription()).isEqualTo("Esse produto");
//    }
//
//    @Test
//    public void whenList_theSearchProduct() {
//        Product product = new Product(new ProductDadosDTO("Teste3", "Esse produto é um pulverizador", null, null, null));
//        productRepository.save(product);
//        Optional<Product> all = productRepository.findById(product.getId());
//        Assertions.assertTrue(all.isPresent());
//
//    }
//
//    @Test
//    @DisplayName(value = "Deve deletar um produto")
//    public void whenDelete_theDeleteProduct() {
//        Product product = new Product(new ProductDadosDTO("Teste3", "Esse produto é um pulverizador", null, null, null));
//        productRepository.save(product);
//        productRepository.deleteById(product.getId());
//        assertThat(productRepository.findById(product.getId())).isEmpty();
//    }
//}
