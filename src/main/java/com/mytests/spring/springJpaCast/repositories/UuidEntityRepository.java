package com.mytests.spring.springJpaCast.repositories;

import com.mytests.spring.springJpaCast.model.Item;
import com.mytests.spring.springJpaCast.model.UuidEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;


public interface UuidEntityRepository extends CrudRepository<UuidEntity, UUID> {

    // uuid:
    @Query(value = "select e from uuid_entity e where e.id = cast(?1 as uuid)")
    List<UuidEntity> testCastToShortTypeName(String id);

    @Query(value = "select e from uuid_entity e where e.id = cast(?1 as java.util.UUID)")
    List<UuidEntity> testCastToTypeFQN(String id);

     // https://youtrack.jetbrains.com/issue/IDEA-352888
    // string, character, byte, short, integer, long, float, double, time, date, timestamp, localtime, localdate, localdatetime,
    // zoneddatetime, biginteger, bigdecimal, duration, instant, binary, boolean, truefalse, yesno, numericboolean

    @Query("select e from uuid_entity e where cast(e.foo as string) = ''")
    List<UuidEntity> castToString1();
    @Query("select e from uuid_entity e where cast(e.foo as StRing) = ''")
    List<UuidEntity> castToString2();
    @Query("select e from uuid_entity e where cast(e.foo as java.lang.String) = ''")
    List<UuidEntity> castToString3();
    @Query("select e from uuid_entity e where cast(e.char1 as character) = 'a'") // 'number type is expected'
    List<UuidEntity> castToCharacter1();
    @Query("select e from uuid_entity e where cast(e.char1 as Character) = 'a'")
    List<UuidEntity> castToCharacter2();
    @Query("select e from uuid_entity e where cast(e.char1 as java.lang.Character) = 'a'")
    List<UuidEntity> castToCharacter3();
    @Query("select e from uuid_entity e where cast(e.flag1 as byte) = 0") // 'byte type is expected'
    List<UuidEntity> castToByte1();
    @Query("select e from uuid_entity e where cast(e.flag1 as Byte) = 1")
    List<UuidEntity> castToByte2();
    @Query("select e from uuid_entity e where cast(e.flag1 as java.lang.Byte) = 0")
    List<UuidEntity> castToByte3();
    @Query("select e from uuid_entity e where cast(e.num1 as short) = 0") // 'short type is expected'
    List<UuidEntity> castToShort1();
    @Query("select e from uuid_entity e where cast(e.num1 as Short) = 0")
    List<UuidEntity> castToShort2();
    @Query("select e from uuid_entity e where cast(e.num1 as java.lang.Short) = 0")
    List<UuidEntity> castToShort3();
    @Query("select e from uuid_entity e where cast(e.num1 as integer) = 0") // 'integer type is expected'
    List<UuidEntity> castToInteger1();
    @Query("select e from uuid_entity e where cast(e.num1 as Integer) = 0")
    List<UuidEntity> castToInteger2();
    @Query("select e from uuid_entity e where cast(e.num1 as java.lang.Integer) = 0")
    List<UuidEntity> castToInteger3();
    @Query("select e from uuid_entity e where cast(e.num2 as biginteger) = 0")
    List<UuidEntity> castToBigInteger1();
    @Query("select e from uuid_entity e where cast(e.num2 as BigIntEger) = 0")
    List<UuidEntity> castToBigInteger2();
    @Query("select e from uuid_entity e where cast(e.num2 as java.math.BigInteger) = 0")
    List<UuidEntity> castToBigInteger3();
    @Query("select e from uuid_entity e where cast(e.num2 as bigdecimal) = 0")
    List<UuidEntity> castToBigDecimal1();
    @Query("select e from uuid_entity e where cast(e.num2 as BigDecimal) = 0") // 'BigDecimal type is expected'
    List<UuidEntity> castToBigDecimal2();
    @Query("select e from uuid_entity e where cast(e.num2 as java.math.BigDecimal) = :arg")
    List<UuidEntity> castToBigDecimal3(BigDecimal arg);
    @Query("select e from uuid_entity e where cast(e.num1 as long) = 1L") // 'long type is expected'
    List<UuidEntity> castToLong1();
    @Query("select e from uuid_entity e where cast(e.num1 as Long) = 1L")
    List<UuidEntity> castToLong2();
    @Query("select e from uuid_entity e where cast(e.num1 as java.lang.Long) = 1L")
    List<UuidEntity> castToLong3();
    @Query("select e from uuid_entity e where cast(e.num3 as float) = 1.1") // 'float type is expected'
    List<UuidEntity> castToFloat1();
    @Query("select e from uuid_entity e where cast(e.num3 as Float) = 1.1")
    List<UuidEntity> castToFloat2();
    @Query("select e from uuid_entity e where cast(e.num3 as java.lang.Float) = 1.1")
    List<UuidEntity> castToFloat3();
    @Query("select e from uuid_entity e where cast(e.num2 as double) = 0") // 'double type is expected'
    List<UuidEntity> castToDouble1();
    @Query("select e from uuid_entity e where cast(e.num2 as Double) = 0")
    List<UuidEntity> castToDouble2();
    @Query("select e from uuid_entity e where cast(e.num2 as java.lang.Double) = 0")
    List<UuidEntity> castToDouble3();
    @Query("select e from uuid_entity e where cast(e.date1 as date) = local date ")
    List<UuidEntity> castToDate1();
    @Query("select e from uuid_entity e where cast(e.date1 as Date) = local date ")
    List<UuidEntity> castToDate2();
    @Query("select e from uuid_entity e where cast(e.date1 as java.util.Date) = local date ")
    List<UuidEntity> castToDate3();
    @Query("select e from uuid_entity e where cast(e.time1 as time) = local time ") // cannot resolve symbol 'time'
    List<UuidEntity> castToTime1();
    @Query("select e from uuid_entity e where cast(e.time1 as Time) = local time ") // cannot resolve symbol 'Time'
    List<UuidEntity> castToTime2();
    @Query("select e from uuid_entity e where cast(e.time2 as timestamp ) = current timestamp ")
    List<UuidEntity> castToTimestamp1();
    @Query("select e from uuid_entity e where cast(e.time2 as TimeStamp) = current_timestamp ")
    List<UuidEntity> castToTimestamp2();
    @Query("select e from uuid_entity e where cast(e.time1 as localtime) = local time ")
    List<UuidEntity> castToLocaltime1();
    @Query("select e from uuid_entity e where cast(e.time1 as LocalTime) = local time ")
    List<UuidEntity> castToLocaltime2();
    @Query("select e from uuid_entity e where cast(e.date1 as localdate) = local date ")
    List<UuidEntity> castToLocaldate1();
    @Query("select e from uuid_entity e where cast(e.date1 as LocalDate) = local_date ")
    List<UuidEntity> castToLocaldate2();
    @Query("select e from uuid_entity e where cast(e.date1 as localdatetime) = local datetime ")
    List<UuidEntity> castToLocaldatetime1();
    @Query("select e from uuid_entity e where cast(e.date1 as LocalDateTime) = local_datetime ")
    List<UuidEntity> castToLocaldatetime2();
    @Query("select e from uuid_entity e where cast(e.date1 as zoneddatetime) = local datetime ") // cannot resolve symbol 'zoneddatetime'
    List<UuidEntity> castToZoneddatetime1();
    @Query("select e from uuid_entity e where cast(e.date1 as ZonedDateTime) = local_datetime ") // cannot resolve symbol 'ZonedDateTime'
    List<UuidEntity> castToZoneddatetime2();
    @Query("select e from uuid_entity e where cast(timediff(now(),e.time1) as duration) = 0") // cannot resolve symbol 'duration'
    List<UuidEntity> castToDuration1();
    @Query("select e from uuid_entity e where cast(timediff(now(),e.time1) as DuRation) = 0") // cannot resolve symbol 'DuRation'
    List<UuidEntity> castToDuration2();
    @Query("select e from uuid_entity e where cast(timediff(now(),e.time1) as java.time.Duration) = 0") // java.time.Duration type is expected
    List<UuidEntity> castToDuration3();
    @Query("select e from uuid_entity e where cast(e.time2 as instant) = current timestamp ")  // cannot resolve symbol 'instant'
    List<UuidEntity> castToInstant1();
    @Query("select e from uuid_entity e where cast(e.time2 as Instant) = current timestamp ") // cannot resolve symbol 'Instant'
    List<UuidEntity> castToInstant2();
    @Query("select e from uuid_entity e where cast(e.time2 as java.time.Instant) = current timestamp ")
    List<UuidEntity> castToInstant3();
    @Query("select e from uuid_entity e where cast(e.flag3 as binary) = null ") // cannot resolve symbol 'binary'
    List<UuidEntity> castToBinary1();
    @Query("select e from uuid_entity e where cast(e.flag3 as Binary) = null ") // cannot resolve symbol 'Binary'
    List<UuidEntity> castToBinary2();
    @Query("select e from uuid_entity e where cast(e.flag1 as boolean) = true")
    List<UuidEntity> castToBoolean1();
    @Query("select e from uuid_entity e where cast(e.flag1 as Boolean) = false")
    List<UuidEntity> castToBoolean2();
    @Query("select e from uuid_entity e where cast(e.flag1 as java.lang.Boolean) = true")
    List<UuidEntity> castToBoolean3();
    @Query("select e from uuid_entity e where cast(e.flag1 as truefalse) = true") // cannot resolve symbol 'truefalse'
    List<UuidEntity> castToTrueFalse1();
    @Query("select e from uuid_entity e where cast(e.flag1 as TrueFalse) = false") // cannot resolve symbol 'TrueFalse'
    List<UuidEntity> castToTrueFalse2();
    @Query("select cast(e.flag2 as yesno) from uuid_entity e ")
    List<String> castToYesNo0();
    @Query("select e from uuid_entity e where cast(e.flag1 as yesno) = true") // cannot resolve symbol 'yesno'
    List<UuidEntity> castToYesNo1();
    @Query("select e from uuid_entity e where cast(e.flag1 as YesNo) = false") // cannot resolve symbol 'YesNo'
    List<UuidEntity> castToYesNo2();
    @Query("select e from uuid_entity e where cast(e.flag1 as numericboolean) = 0") // cannot resolve symbol 'numericboolean'
    List<UuidEntity> castToNumericBoolean1();
    @Query("select e from uuid_entity e where cast(e.flag1 as NumericBoolean) = 1") // cannot resolve symbol 'NumericBoolean'
    List<UuidEntity> castToNumericBoolean2();

    // https://youtrack.jetbrains.com/issue/IDEA-352890
    @Query("select e from uuid_entity e where 2 * cast(e.num1 as BigDecimal) > :arg ")
    List<UuidEntity> castToBigDecimal4(BigDecimal arg);
    @Query("select e from uuid_entity e where 2 * cast(e.num1 as BigInteger) > :arg ")
    List<UuidEntity> castToBigInteger4(BigInteger arg);


}
