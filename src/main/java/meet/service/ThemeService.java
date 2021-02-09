package meet.service;

import java.util.List;

import meet.model.domain.dto.Theme;

public interface ThemeService {
	List<Theme> getThemeList();

	Theme getTheme(String id);

	void updateTheme(Theme theme);

	void deleteTheme(Theme theme);
}
