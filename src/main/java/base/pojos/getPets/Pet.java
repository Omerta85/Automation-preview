package base.pojos.getPets;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Pet {
    public Long id;
    public Category category;
    public String name;
    public ArrayList<String> photoUrls;
    public ArrayList<Tag> tags;
    public String status;
}
