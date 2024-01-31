package moblog.bubun.moblogproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final ArrayList<Place> places;
    
    public void addPlace(Place place){
        places.add(place);
    }
    public List<Place> getBlogs(){
        return places;
    }
    public Place getExplore(int index){
        return places.get(index);
    }
}
