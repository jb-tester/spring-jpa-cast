package com.mytests.spring.springJpaCast.repositories;

import com.mytests.spring.springJpaCast.model.UuidEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
@Transactional
public class UuidEntityQueryService {

    @PersistenceContext
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    // UUID casting methods
    public List<UuidEntity> testCastToShortTypeName(String id) {
        return getSession()
                .createQuery("select e from uuid_entity e where e.id = cast(?1 as uuid)", UuidEntity.class)
                .setParameter(1, id)
                .getResultList();
    }

    public List<UuidEntity> testCastToTypeFQN(String id) {
        return getSession()
                .createQuery("select e from uuid_entity e where e.id = cast(?1 as java.util.UUID)", UuidEntity.class)
                .setParameter(1, id)
                .getResultList();
    }

    // String casting methods
    public List<UuidEntity> castToString1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.foo as string) = ''", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToString2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.foo as StRing) = ''", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToString3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.foo as java.lang.String) = ''", UuidEntity.class)
                .getResultList();
    }

    // Character casting methods
    public List<UuidEntity> castToCharacter1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.char1 as character) = 'a'", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToCharacter2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.char1 as Character) = 'a'", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToCharacter3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.char1 as java.lang.Character) = 'a'", UuidEntity.class)
                .getResultList();
    }

    // Byte casting methods
    public List<UuidEntity> castToByte1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as byte) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToByte2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as Byte) = 1", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToByte3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as java.lang.Byte) = 0", UuidEntity.class)
                .getResultList();
    }

    // Short casting methods
    public List<UuidEntity> castToShort1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as short) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToShort2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as Short) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToShort3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as java.lang.Short) = 0", UuidEntity.class)
                .getResultList();
    }

    // Integer casting methods
    public List<UuidEntity> castToInteger1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as integer) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToInteger2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as Integer) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToInteger3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as java.lang.Integer) = 0", UuidEntity.class)
                .getResultList();
    }

    // BigInteger casting methods
    public List<UuidEntity> castToBigInteger1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as biginteger) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBigInteger2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as BigIntEger) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBigInteger3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as java.math.BigInteger) = 0", UuidEntity.class)
                .getResultList();
    }

    // BigDecimal casting methods
    public List<UuidEntity> castToBigDecimal1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as bigdecimal) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBigDecimal2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as BigDecimal) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBigDecimal3(BigDecimal arg) {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as java.math.BigDecimal) = :arg", UuidEntity.class)
                .setParameter("arg", arg)
                .getResultList();
    }

    // Long casting methods
    public List<UuidEntity> castToLong1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as long) = 1L", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToLong2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as Long) = 1L", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToLong3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num1 as java.lang.Long) = 1L", UuidEntity.class)
                .getResultList();
    }

    // Float casting methods
    public List<UuidEntity> castToFloat1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num3 as float) = 1.1", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToFloat2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num3 as Float) = 1.1", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToFloat3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num3 as java.lang.Float) = 1.1", UuidEntity.class)
                .getResultList();
    }

    // Double casting methods
    public List<UuidEntity> castToDouble1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as double) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDouble2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as Double) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDouble3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.num2 as java.lang.Double) = 0", UuidEntity.class)
                .getResultList();
    }

    // Date casting methods
    public List<UuidEntity> castToDate1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as date) = local date", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDate2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as Date) = local date", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDate3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as java.util.Date) = local date", UuidEntity.class)
                .getResultList();
    }

    // Time casting methods
    public List<UuidEntity> castToTime1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time1 as time) = local time", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToTime2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time1 as Time) = local time", UuidEntity.class)
                .getResultList();
    }

    // Timestamp casting methods
    public List<UuidEntity> castToTimestamp1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time2 as timestamp) = current timestamp", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToTimestamp2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time2 as TimeStamp) = current_timestamp", UuidEntity.class)
                .getResultList();
    }

    // LocalTime casting methods
    public List<UuidEntity> castToLocaltime1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time1 as localtime) = local time", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToLocaltime2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time1 as LocalTime) = local time", UuidEntity.class)
                .getResultList();
    }

    // LocalDate casting methods
    public List<UuidEntity> castToLocaldate1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as localdate) = local date", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToLocaldate2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as LocalDate) = local_date", UuidEntity.class)
                .getResultList();
    }

    // LocalDateTime casting methods
    public List<UuidEntity> castToLocaldatetime1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as localdatetime) = local datetime", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToLocaldatetime2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as LocalDateTime) = local_datetime", UuidEntity.class)
                .getResultList();
    }

    // ZonedDateTime casting methods
    public List<UuidEntity> castToZoneddatetime1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as zoneddatetime) = local datetime", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToZoneddatetime2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.date1 as ZonedDateTime) = local_datetime", UuidEntity.class)
                .getResultList();
    }

    // Duration casting methods
    public List<UuidEntity> castToDuration1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(timediff(now(),e.time1) as duration) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDuration2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(timediff(now(),e.time1) as DuRation) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToDuration3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(timediff(now(),e.time1) as java.time.Duration) = 0", UuidEntity.class)
                .getResultList();
    }

    // Instant casting methods
    public List<UuidEntity> castToInstant1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time2 as instant) = current timestamp", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToInstant2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time2 as Instant) = current timestamp", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToInstant3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.time2 as java.time.Instant) = current timestamp", UuidEntity.class)
                .getResultList();
    }

    // Binary casting methods
    public List<UuidEntity> castToBinary1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag3 as binary) = null", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBinary2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag3 as Binary) = null", UuidEntity.class)
                .getResultList();
    }

    // Boolean casting methods
    public List<UuidEntity> castToBoolean1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as boolean) = true", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBoolean2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as Boolean) = false", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToBoolean3() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as java.lang.Boolean) = true", UuidEntity.class)
                .getResultList();
    }

    // TrueFalse casting methods
    public List<UuidEntity> castToTrueFalse1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as truefalse) = true", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToTrueFalse2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as TrueFalse) = false", UuidEntity.class)
                .getResultList();
    }

    // YesNo casting methods
    @SuppressWarnings("unchecked")
    public List<String> castToYesNo0() {
        return getSession()
                .createQuery("select cast(e.flag2 as yesno) from uuid_entity e")
                .getResultList();
    }

    public List<UuidEntity> castToYesNo1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as yesno) = true", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToYesNo2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as YesNo) = false", UuidEntity.class)
                .getResultList();
    }

    // NumericBoolean casting methods
    public List<UuidEntity> castToNumericBoolean1() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as numericboolean) = 0", UuidEntity.class)
                .getResultList();
    }

    public List<UuidEntity> castToNumericBoolean2() {
        return getSession()
                .createQuery("select e from uuid_entity e where cast(e.flag1 as NumericBoolean) = 1", UuidEntity.class)
                .getResultList();
    }

    // BigDecimal and BigInteger arithmetic methods
    public List<UuidEntity> castToBigDecimal4(BigDecimal arg) {
        return getSession()
                .createQuery("select e from uuid_entity e where 2 * cast(e.num1 as BigDecimal) > :arg", UuidEntity.class)
                .setParameter("arg", arg)
                .getResultList();
    }

    public List<UuidEntity> castToBigInteger4(BigInteger arg) {
        return getSession()
                .createQuery("select e from uuid_entity e where 2 * cast(e.num1 as BigInteger) > :arg", UuidEntity.class)
                .setParameter("arg", arg)
                .getResultList();
    }
}
