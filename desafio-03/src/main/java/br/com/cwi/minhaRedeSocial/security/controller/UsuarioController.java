package br.com.cwi.minhaRedeSocial.security.controller;

import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.CadastrarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.request.PublicarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.*;
import br.com.cwi.minhaRedeSocial.security.service.*;
import br.com.cwi.minhaRedeSocial.security.service.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @Autowired
    private DetalharUsuarioService detalharUsuarioService;

    @Autowired
    private SolicitacoesUsuarioService solicitacoesUsuarioService;

    @Autowired
    private PublicarUsuarioService publicarUsuarioService;

    @Autowired
    private PostagensUsuariosService postagensUsuariosService;

    @Autowired
    private BuscarUsuariosService buscarUsuariosService;

    @Autowired
    private ListarAmigosService listarAmigosService;

    @Autowired
    private PerfilAmigoService perfilAmigoService;

    @Autowired
    private EditarUsuarioService editarUsuarioService;

    @PostMapping
    @ResponseStatus(CREATED)
    public CadastrarUsuarioResponse cadastrar(@Valid @RequestBody CadastrarUsuarioRequest request){
        return cadastrarUsuarioService.cadastrar(request);
    }

    @GetMapping("/detalhar")
    @ResponseStatus(OK)
    public DetalharUsuarioResponse detalhar(){
        return detalharUsuarioService.detalhar();
    }

    @GetMapping("/solicitacoes")
    @ResponseStatus(OK)
    public Page<SolicitacoesUsuarioResponse> solicitacoes(Pageable pageable){
        return solicitacoesUsuarioService.solicitacoes(pageable);
    }

    @PostMapping("/postar")
    @ResponseStatus(CREATED)
    public PublicarUsuarioResponse publicar(@Valid @RequestBody PublicarUsuarioRequest request){
        return publicarUsuarioService.publicar(request);
    }

    @GetMapping("/postagens")
    @ResponseStatus(OK)
    public Page<PostagensUsuariosResponse> postagens(Pageable pageable){
        return postagensUsuariosService.postagens(pageable);
    }

    @GetMapping("/search")
    @ResponseStatus(OK)
    public Page<BuscarUsuariosResponse> buscar(@RequestParam String texto, Pageable pageable){
        return buscarUsuariosService.buscar(texto, pageable);
    }

    @GetMapping("/amigos")
    @ResponseStatus(OK)
    public Page<ListarAmigosResponse> listarAmigos(Pageable pageable){
        return listarAmigosService.listar(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PerfilAmigoResponse perfilAmigo(@PathVariable Long id){
        return perfilAmigoService.perfil(id);
    }

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    public void editar(@Valid @RequestBody EditarUsuarioRequest request){
        editarUsuarioService.editar(request);
    }

}
