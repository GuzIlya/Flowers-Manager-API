package net.guz.flowersmanagerapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.guz.flowersmanagerapi.entity.Sort;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SortDto {
    private Long id;

    private String title;

    private String value;

    public static SortDto from(Sort sort) {
        return SortDto.builder()
                .id(sort.getId())
                .title(sort.getTitle())
                .value(sort.getValue())
                .build();
    }

    public static List<SortDto> from(List<Sort> sorts) {
        return sorts.stream().map(SortDto::from).collect(Collectors.toList());
    }
}
