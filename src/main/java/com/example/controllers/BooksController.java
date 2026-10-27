package com.example.controllers;

import com.example.crc.*;
import com.example.splab.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BookService bookService;
    private final CommandExecutor commandExecutor;

    @Autowired
    public BooksController(BookService bookService, CommandExecutor commandExecutor) {
        this.bookService = bookService;
        this.commandExecutor = commandExecutor;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        GetAllBookCommand getAllBookCommand = new GetAllBookCommand(bookService);
        return ResponseEntity.ok(commandExecutor.execute(getAllBookCommand));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id){
        GetBookByIdCommand getBookByIdCommand = new GetBookByIdCommand(bookService, id);

        Book book = getBookByIdCommand.execute();
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createBook(@RequestBody Book book){
        CreateBookCommand createBookCommand = new CreateBookCommand(bookService, book);
        String taskId = commandExecutor.executeAsync(createBookCommand);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(Map.of(
                        "status", "Accepted",
                        "taskId", taskId,
                        "checkStatusUrl", "/books/tasks/" + taskId
                ));
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<?> getTaskStatus(@PathVariable String taskId){
        CommandExecutor.AsyncTaskStatus status = commandExecutor.getTaskStatus(taskId);

        if(status == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(status);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
        UpdateBookCommand updateBookCommand = new UpdateBookCommand(bookService, id, book);
        return ResponseEntity.ok(commandExecutor.execute(updateBookCommand));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable long id){
        DeleteCommand deleteCommand = new DeleteCommand(bookService, id);
        boolean deleteFlag = commandExecutor.execute(deleteCommand);

        return deleteFlag ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
