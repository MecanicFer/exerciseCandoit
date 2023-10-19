package exercise.candoit.exerciseCandoit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import exercise.candoit.exerciseCandoit.constant.ViewConstant;
import exercise.candoit.exerciseCandoit.entity.User;
import exercise.candoit.exerciseCandoit.service.UserRegisterService;

@Controller
@RequestMapping("/vistasAdmin")
public class VistasController {

	@Autowired
	private UserRegisterService servicio;

	@GetMapping("/user")
	public String user() {
		return ViewConstant.USER;
	}

	// Show contact list from table in MYSQL
	@GetMapping("/contacts")
	public String contacts(Model modelo) {
		// Get the list of users and add it to the model
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return ViewConstant.CONTACTS;
	}

	// Method controller to delete users
	@GetMapping("/contacts/delete/{id}")
	public String eliminarContacto(@PathVariable Long id, Model modelo) {
		servicio.eliminarUsuarioPorId(id);

		// Reload the user list and add it back to the model
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		return ViewConstant.CONTACTS;
	}

	// Controller method that shows the user data to be edited in the template
	@GetMapping("/contacts/edit/{id}")
	public String editarContacto(@PathVariable Long id, Model modelo) {
		// Get the user by their ID
		User usuario = servicio.obtenerUsuarioPorId(id);

		// Add the user to the model
		modelo.addAttribute("usuario", usuario);

		// Return the contact editing view
		return "editContacts";
	}

	// Controller method that edits the registered user's data
	@PostMapping("/contacts/edit/{id}")
	public String actualizarContacto(@PathVariable Long id, @ModelAttribute User user) {
		// Logic to update the user
		User usuarioActualizado = servicio.actualizarUsuario(user);

		if (usuarioActualizado != null) {
			return "redirect:/vistasAdmin/contacts"; // Redirect to contacts view if update is successful
		} else {

			// Display an error message or redirect to a specific error page.
			return "redirect:/error";
		}
	}

}
