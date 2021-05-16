package org.fis.pc.services;

import org.apache.commons.io.FileUtils;
import org.fis.pc.exceptions.*;
import org.fis.pc.model.Post;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.testfx.assertions.api.Assertions.assertThat;


class PostServiceTest {

    private static final String NAME="name";
    private static final String PRICE="120";
    private static final String CATEGORY="category";
    private static final String DESCRIPTION="descriere";
    private static final String IMAGE="image";
    private static final String OWNER="ownername";

    @BeforeEach
    public void setUp() throws IOException {
        FileSystemService.APPLICATION_FOLDER=".test-photography-chest";
        //FileSystemService.initDirectory();
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        PostService.initDatabase();
    }

    @Test
    void testDatabaseIsInitialised() {
        assertThat(PostService.getAllPosts()).isNotNull();
        assertThat(PostService.getAllPosts()).isEmpty();
    }

    @Test
    void postIsAddedInDatabase() throws NoNameException, NoImageSelectedException, NoCategoryException, NoDescriptionException, NoPriceException {
        PostService.addPost(NAME,PRICE,CATEGORY,DESCRIPTION,IMAGE,OWNER);
        assertThat(PostService.getAllPosts()).isNotEmpty();
        assertThat(PostService.getAllPosts()).size().isEqualTo(1);
        Post post = PostService.getAllPosts().get(0);
        assertThat(post).isNotNull();
        assertThat(post.getName()).isEqualTo(NAME);
        assertThat(post.getPrice()).isEqualTo(PRICE);
        assertThat(post.getCategory()).isEqualTo(CATEGORY);
        assertThat(post.getDescription()).isEqualTo(DESCRIPTION);
        assertThat(post.getImage()).isEqualTo(IMAGE);
        assertThat(post.getOwnerName()).isEqualTo(OWNER);
    }

   @Test
    void testItemIsDeletedFromDatabase() throws NoNameException, NoImageSelectedException, NoCategoryException, NoDescriptionException, NoPriceException {
       PostService.addPost(NAME,PRICE,CATEGORY,DESCRIPTION,IMAGE,OWNER);
       Post post = PostService.getAllPosts().get(0);
       PostService.deletePost(post);
       assertThat(PostService.getAllPosts()).isEmpty();
   }

   @Test
    void testNoImageSelectedException(){
        assertThrows(NoImageSelectedException.class, () -> {
            PostService.addPost(NAME,PRICE,CATEGORY,DESCRIPTION,null,OWNER);
       });
   }

    @Test
    void testNoPriceException(){
        assertThrows(NoPriceException.class, () -> {
            PostService.addPost(NAME,"",CATEGORY,DESCRIPTION,IMAGE,OWNER);
        });
    }

    @Test
    void testNoCategoryException(){
        assertThrows(NoCategoryException.class, () -> {
            PostService.addPost(NAME,PRICE,"",DESCRIPTION,IMAGE,OWNER);
        });
    }

    @Test
    void testNoNameException(){
        assertThrows(NoNameException.class, () -> {
            PostService.addPost("",PRICE,CATEGORY,DESCRIPTION,IMAGE,OWNER);
        });
    }

    @Test
    void testNoDescriptionException(){
        assertThrows(NoDescriptionException.class, () -> {
            PostService.addPost(NAME,PRICE,CATEGORY,"",IMAGE,OWNER);
        });
    }
}