package io.reflectoring.reviewapp.application.port.in;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.reflectoring.reviewapp.application.port.in.RegisterBookUseCase.NonUniqueBookTitleException;
import io.reflectoring.reviewapp.application.port.in.RegisterBookUseCase.RegisterBookCommand;
import io.reflectoring.reviewapp.common.SelfValidating;
import lombok.Getter;

public interface RegisterItemUseCase {
	
	
	
	void registerItem(RegisterItemCommand command) throws NonUniqueItemTitleException;


	  @Getter
	  final class RegisterItemCommand extends SelfValidating<RegisterBookCommand> {

	    @NotEmpty
	    @Getter
	    private final String title;

	    @NotNull
	    @Getter
	    private final String data;

	    public RegisterItemCommand(String title, String data) {
	      this.title = title;
	      this.data = data;
	      validateSelf();
	    }
	  }

	  final class NonUniqueItemTitleException extends RuntimeException {

	    public NonUniqueItemTitleException(String title) {
	      super(String.format("El titulo de la tarea debe de ser unico (este es el titulo en cuestion: '%s').", title));
	    }

	  }
}
