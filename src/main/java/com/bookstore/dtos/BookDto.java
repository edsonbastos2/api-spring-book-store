package com.bookstore.dtos;

import java.util.Set;

public record BookDto(String title, Long publisherId, Set<Long> authorsId, String reviewComment) {
}
