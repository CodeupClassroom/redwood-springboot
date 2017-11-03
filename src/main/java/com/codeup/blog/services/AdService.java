package com.codeup.blog.services;

import com.codeup.blog.models.Ad;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("adSvc")
public class AdService {

    // We create the list and we initialize the list
    private List<Ad> ads = new ArrayList<>();

    // In the constructor we make sure there's dummy data ready
    public AdService(){
        createDummy();
    }

    // Gets all the ads
    public List<Ad> findAll(){
        return ads;
    }

    // Gets one ad
    public Ad findOne(Long id){
        return ads.get((int) (id - 1));
    }

    // Saves an ad with just the title and desc
    public Ad save(Ad ad){
        ad.setId( (long) (ads.size() + 1));
        ads.add(ad);
        return ad;
    }

    // Creates a bunch of dummy data
    private void createDummy(){
        this.save(new Ad("Example 1", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));

       this.save(new Ad( "Example 2", "QWE Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));

        this.save(new Ad("Example 3", "ASD Lorem ipsum dolor sit amet, consectetur adipisicing elit. Adipisci atque commodi eligendi necessitatibus voluptates. At distinctio dolores minus molestiae mollitia nemo sapiente ut veniam voluptates! Corporis distinctio error quaerat vel!"));

    }


}
