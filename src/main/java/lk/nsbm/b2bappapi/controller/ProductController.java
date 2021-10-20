package lk.nsbm.b2bappapi.controller;

import lk.nsbm.b2bappapi.dto.ProductDTO;
import lk.nsbm.b2bappapi.dto.UserDTO;
import lk.nsbm.b2bappapi.dto.UserResponseDTO;
import lk.nsbm.b2bappapi.entity.Product;
import lk.nsbm.b2bappapi.service.ProductService;
import lk.nsbm.b2bappapi.service.UserService;
import lk.nsbm.b2bappapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductDTO dto) {
        productService.saveProduct(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @PostMapping(path = "/saveProductImage")
    public ResponseEntity uploadCarImage(@RequestPart("file") MultipartFile multipartFile) {
        System.out.println(multipartFile.getOriginalFilename());
        try {
            File uploadsDir = new File("D:/My Pro/b2bapp-frontEnd/b2bapp-FrontEND/img/product");
            uploadsDir.mkdir();
            multipartFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + multipartFile.getOriginalFilename()));
        }  catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = multipartFile.getOriginalFilename();


        StandardResponse standardResponse = new StandardResponse("200", "Success!", filePath);
        return new ResponseEntity(standardResponse, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllProducts() {
        ArrayList<ProductDTO> allProducts = productService.getAllProducts();
        return new ResponseEntity(new StandardResponse("200", "Done", allProducts), HttpStatus.OK);
    }



    @GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchProduct(@PathVariable String name) {
        ProductDTO productDTO = productService.searchProduct(name);
        return new ResponseEntity(new StandardResponse("200", "Done", productDTO), HttpStatus.OK);
    }


    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteUser(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }

    @PutMapping(path = ("/updateProduct"),consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody ProductDTO dto) {
        productService.updateProduct(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
