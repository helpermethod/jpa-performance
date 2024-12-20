package io.helpermethod.jpa.performance.posts

import java.util.UUID
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository : JpaRepository<Comment, UUID> {
    @EntityGraph(attributePaths = ["post"])
    fun findCommentById(id: UUID): Comment
}