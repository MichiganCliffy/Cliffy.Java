package cliffy.data;

import cliffy.common.*;
import java.util.*;

public interface IBlogRepository {
    Blog getPosts(String[] tags);
    BlogPost getPost(String id);
    String getUriSource(String tag);
    String getUriSource(Date archive);
}