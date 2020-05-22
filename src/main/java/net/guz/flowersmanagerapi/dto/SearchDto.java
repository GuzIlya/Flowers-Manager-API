package net.guz.flowersmanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.guz.flowersmanagerapi.entity.Order;
import net.guz.flowersmanagerapi.entity.Search;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchDto {
    private Long id;

    private String title;

    private String value;

    public static SearchDto from(Search search) {
        return SearchDto.builder()
                .id(search.getId())
                .title(search.getTitle())
                .value(search.getValue())
                .build();
    }

    public static List<SearchDto> from(List<Search> searches) {
        return searches.stream().map(SearchDto::from).collect(Collectors.toList());
    }
}
