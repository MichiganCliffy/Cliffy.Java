package cliffy.data;

import java.util.List;
import cliffy.common.*;

public interface IPhotographRepository {
	List<PhotographAlbum> getAlbums();
    PhotographAlbum getAlbum(List<String> tags, String setId);
    PhotographAlbum getPhotographs(List<String> tags, int count, int page);
    Photograph getPhotograph(String id);
}
