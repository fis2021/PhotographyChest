package org.fis.pc.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.fis.pc.exceptions.NoImageSelectedException;
import org.fis.pc.model.Post;

import static org.fis.pc.services.FileSystemService.getPathToFile;

public class PostService {
    private static ObjectRepository<Post> postRepository;

    public static void initDatabase(){
        Nitrite database = Nitrite.builder().filePath(getPathToFile("photography-chest-posts.db").toFile()).openOrCreate("test", "test");
        postRepository = database.getRepository(Post.class);
        int count = 0;
        for (Post post : postRepository.find()) {
            count++;
        }
        Post.setCount(count);
    }

    public static ObjectRepository<Post> getPostRepository(){
        return postRepository;
    }

    public static void addPost(String name, String price, String category, String description, String image, String ownerName) throws NoImageSelectedException {
        Post post = new Post(name,price,category,description,image,ownerName);
        checkIfImageSelected(image);
        postRepository.insert(post);

    }

    public static void checkIfImageSelected(String image) throws NoImageSelectedException {
        if (image==null)
            throw new NoImageSelectedException();
    }

}
