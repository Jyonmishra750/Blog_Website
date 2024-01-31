package moblog.bubun.moblogproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final ArrayList<Places> places;

    public void addPlace(Places place) {
        places.add(place);
    }

    public List<Places> getBlogs() {
        return places;
    }

    public Places getExplore(int index) {
        return places.get(index);
    }
}
