package io.helpermethod.jpa.performance.posts

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, UUID>