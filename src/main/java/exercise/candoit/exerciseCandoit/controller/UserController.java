package exercise.candoit.exerciseCandoit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exercise.candoit.exerciseCandoit.constant.ViewConstant;
import exercise.candoit.exerciseCandoit.response.UserRegister;
import exercise.candoit.exerciseCandoit.service.UserRegisterService;

@Controller
@RequestMapping("/register")
public class UserController {

	private UserRegisterService userRegisterService;

	public UserController(UserRegisterService userRegisterService) {
		super();
		this.userRegisterService = userRegisterService;
	}

	@ModelAttribute("user")
	public UserRegister retornarNuevoUsuario() {
		return new UserRegister();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return ViewConstant.NEWUSER_FORM;
	}

	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("user") UserRegister userRegister) {
		userRegisterService.save(userRegister);
		return "redirect:/register?exito";
	}

}
