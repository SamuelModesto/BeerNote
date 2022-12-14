package com.unipampa.Pessoas.service;

import com.unipampa.Pessoas.model.Pessoa;
import com.unipampa.Pessoas.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PessoaServiceTest {

    private Pessoa pessoa;

    @InjectMocks
    private PessoaService service;

    @Mock
    private PessoaRepository repository;

    public static final Long ID = 1L;
    public static final String NAME = "Samuel";
    public static final String USER = "Samuka";
    public static final String PASSWORD = "123456";

    private void iniciarObjetos() {
        pessoa = new Pessoa(ID, NAME, USER, PASSWORD);
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarObjetos();
    }

    @Test
    void quandoSalvarUmaPessoaRetorneSucesso() {
        when(repository.save(any())).thenReturn(pessoa);
        Pessoa response = service.savePessoa(pessoa);
        assertNotNull(response);
        assertEquals(pessoa.getClass(), response.getClass());
        assertEquals(ID, response.getId());
    }

    @Test
    void quandoBuscarPessoaPorIdRetorneUmaInstanciaDePessoa() {
        when(repository.findById(anyLong())).thenReturn(pessoa);
        Pessoa response = service.listById(ID);
        assertNotNull(response);
        assertEquals(pessoa.getClass(), response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(USER, response.getUser());
    }

    @Test
    void quandoBuscarTodasAsPessoasRetorneUmaListaDePessoas() {
        when(repository.findAll()).thenReturn(List.of(pessoa));
        List<Pessoa> response = service.listAllPessoa();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Pessoa.class, response.get(0).getClass());
    }
}