package io.helpermethod.jpa.performance.posts

import java.util.UUID
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CommentRepository : JpaRepository<Comment, UUID> {
    @Query("from Comment c join fetch c.post")
    fun findCommentById(id: UUID): Comment
}