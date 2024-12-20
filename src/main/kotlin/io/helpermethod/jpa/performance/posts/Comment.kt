package io.helpermethod.jpa.performance.posts

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.util.UUID

@Entity
class Comment(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,
    // unidirectional many-to-one
    @ManyToOne(fetch = FetchType.LAZY)
    var post: Post,
    val content: String
)