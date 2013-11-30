package cliffy.data;

import java.util.*;

public interface ICacheRepository {
	Object getFromCache(String key);

    void putInCache(String key, int duration, Object value);

    void removeFromCache(String key);

    void removeFromCache(List<String> keys);

    void clearCache();
}