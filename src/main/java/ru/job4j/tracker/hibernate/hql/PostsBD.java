package ru.job4j.tracker.hibernate.hql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "postsBase")
public class PostsBD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "name")
    private String name;

//    @OneToOne
//    @JoinColumn(name = "candidate_id", unique = true)
//    private Candidate candidate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    public void addPosts(Post post) {
        this.posts.add(post);
    }

    public static PostsBD of(String name) {
        PostsBD postsBD = new PostsBD();
        postsBD.name = name;
        return postsBD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Candidate getCandidate() {
//        return candidate;
//    }
//
//    public void setCandidate(Candidate candidate) {
//        this.candidate = candidate;
//    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostsBD postsBD = (PostsBD) o;
        return id == postsBD.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PostsBD{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
//                + ", candidate="
//                + candidate
                + ", posts="
                + posts
                + '}';
    }
}
