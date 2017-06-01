package br.com.jonyfs.springbootkotlinapi.model

/**
 * Created by jony on 30/05/17.
 */


import com.fasterxml.jackson.annotation.JsonAutoDetect
import org.springframework.data.domain.Auditable
import org.springframework.data.jpa.domain.AbstractPersistable
import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.persistence.ManyToOne
import javax.persistence.MappedSuperclass
import javax.persistence.Temporal
import javax.persistence.TemporalType

@MappedSuperclass
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
abstract class AbstractAuditable<U, PK : Serializable> : AbstractPersistable<PK>(), Auditable<U, PK, LocalDateTime> {
    @Transient
    @ManyToOne
    private var createdBy: U? = null
    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private var createdDate: Date? = null

    @Transient
    @ManyToOne
    private var lastModifiedBy: U? = null

    @Transient
    @Temporal(TemporalType.TIMESTAMP)
    private var lastModifiedDate: Date? = null

    override fun getCreatedBy(): Optional<U> {
        return Optional.ofNullable(this.createdBy)
    }

    override fun setCreatedBy(createdBy: U) {
        this.createdBy = createdBy
    }

    override fun getCreatedDate(): Optional<LocalDateTime> {
        return if (null == this.createdDate) Optional.empty<LocalDateTime>() else Optional.of(LocalDateTime.ofInstant(this.createdDate!!.toInstant(), ZoneId.systemDefault()))
    }

    override fun setCreatedDate(createdDate: LocalDateTime?) {
        if (createdDate == null) {
            this.createdDate = null
        } else {
            this.createdDate = Date.from(createdDate.atZone(ZoneId.systemDefault()).toInstant())
        }
    }

    override fun getLastModifiedBy(): Optional<U> {
        return Optional.ofNullable(this.lastModifiedBy)
    }

    override fun setLastModifiedBy(lastModifiedBy: U) {
        this.lastModifiedBy = lastModifiedBy
    }

    override fun getLastModifiedDate(): Optional<LocalDateTime> {
        return if (null == this.lastModifiedDate) Optional.empty<LocalDateTime>() else Optional.of(LocalDateTime.ofInstant(this.lastModifiedDate!!.toInstant(), ZoneId.systemDefault()))
    }

    override fun setLastModifiedDate(lastModifiedDate: LocalDateTime?) {
        if (lastModifiedDate == null) {
            this.lastModifiedDate = null
        } else {
            this.lastModifiedDate = Date.from(lastModifiedDate.atZone(ZoneId.systemDefault()).toInstant())
        }
    }

}