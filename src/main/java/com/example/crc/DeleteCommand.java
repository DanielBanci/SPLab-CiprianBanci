package com.example.crc;

public class DeleteCommand implements Command<Boolean>{
//    private final BookService bookService;
    private final CommandContext commandContext;
    private final long id;

    public DeleteCommand(CommandContext commandContext, long id) {
        this.commandContext = commandContext;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        if(commandContext.getBooksRepository().existsById((int)id)){
            commandContext.getBooksRepository().deleteById((int)id);
            return true;
        }
        return false;
    }
}
