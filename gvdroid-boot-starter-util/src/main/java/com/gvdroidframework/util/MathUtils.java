package com.gvdroidframework.util;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * 数学计算工具类
 *
 * @author Colin
 * @since 1.0.0
 */
public class MathUtils {

    /**
     * 加法
     *
     * @param addend addend
     * @param augend augend
     * @return BigDecimal
     */
    public static BigDecimal add(double addend, double augend) {
        BigDecimal _addend = BigDecimal.valueOf(addend);
        BigDecimal _augend = BigDecimal.valueOf(augend);
        return _addend.add(_augend);
    }

    /**
     * 加法
     *
     * @param addend addend
     * @param augend augend
     * @return BigDecimal
     */
    public static BigDecimal add(int addend, int augend) {
        BigDecimal _addend = BigDecimal.valueOf(addend);
        BigDecimal _augend = BigDecimal.valueOf(augend);
        return _addend.add(_augend);
    }

    /**
     * 加法
     *
     * @param addend addend
     * @param augend augend
     * @return BigDecimal
     */
    public static BigDecimal add(long addend, long augend) {
        BigDecimal _addend = BigDecimal.valueOf(addend);
        BigDecimal _augend = BigDecimal.valueOf(augend);
        return _addend.add(_augend);
    }

    /**
     * 加法
     *
     * @param addend addend
     * @param augend augend
     * @return BigDecimal
     */
    public static BigDecimal add(Integer addend, Integer augend) {
        if (null == addend)
            addend = 0;
        if (null == augend)
            augend = 0;
        BigDecimal _addend = BigDecimal.valueOf(addend);
        BigDecimal _augend = BigDecimal.valueOf(augend);
        return _addend.add(_augend);
    }

    /**
     * 加法
     *
     * @param addend addend
     * @param augend augend
     * @return BigDecimal
     */
    public static BigDecimal add(BigDecimal addend, BigDecimal augend) {
        if (null == addend)
            addend = BigDecimal.ZERO;
        if (null == augend)
            augend = BigDecimal.ZERO;
        return addend.add(augend);
    }

    /**
     * 减法
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return BigDecimal
     */
    public static BigDecimal subtract(double minuend, double subtrahend) {
        BigDecimal _minuend = BigDecimal.valueOf(minuend);
        BigDecimal _subtrahend = BigDecimal.valueOf(subtrahend);
        return _minuend.subtract(_subtrahend);
    }

    /**
     * 减法
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return BigDecimal
     */
    public static BigDecimal subtract(int minuend, int subtrahend) {
        BigDecimal _minuend = BigDecimal.valueOf(minuend);
        BigDecimal _subtrahend = BigDecimal.valueOf(subtrahend);
        return _minuend.subtract(_subtrahend);
    }

    /**
     * 减法
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return BigDecimal
     */
    public static BigDecimal subtract(long minuend, long subtrahend) {
        BigDecimal _minuend = BigDecimal.valueOf(minuend);
        BigDecimal _subtrahend = BigDecimal.valueOf(subtrahend);
        return _minuend.subtract(_subtrahend);
    }

    /**
     * 减法
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return BigDecimal
     */
    public static BigDecimal subtract(Integer minuend, Integer subtrahend) {
        if (null == minuend)
            minuend = 0;
        if (null == subtrahend)
            subtrahend = 0;
        BigDecimal _minuend = BigDecimal.valueOf(minuend);
        BigDecimal _subtrahend = BigDecimal.valueOf(subtrahend);
        return _minuend.subtract(_subtrahend);
    }

    /**
     * 减法
     *
     * @param minuend    minuend
     * @param subtrahend subtrahend
     * @return BigDecimal
     */
    public static BigDecimal subtract(BigDecimal minuend, BigDecimal subtrahend) {
        if (null == minuend)
            minuend = BigDecimal.ZERO;
        if (null == subtrahend)
            subtrahend = BigDecimal.ZERO;

        return minuend.subtract(subtrahend);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(double multiplicand, double multiplier) {
        BigDecimal _multiplicand = BigDecimal.valueOf(multiplicand);
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return _multiplicand.multiply(_multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(int multiplicand, int multiplier) {
        BigDecimal _multiplicand = BigDecimal.valueOf(multiplicand);
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return _multiplicand.multiply(_multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(long multiplicand, long multiplier) {
        BigDecimal _multiplicand = BigDecimal.valueOf(multiplicand);
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return _multiplicand.multiply(_multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(Integer multiplicand, Integer multiplier) {
        if (null == multiplicand)
            multiplicand = 0;
        if (null == multiplier)
            multiplier = 0;
        BigDecimal _multiplicand = BigDecimal.valueOf(multiplicand);
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return _multiplicand.multiply(_multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal multiplicand,
                                      BigDecimal multiplier) {
        if (null == multiplicand)
            multiplicand = BigDecimal.ZERO;
        if (null == multiplier)
            multiplier = BigDecimal.ZERO;
        return multiplicand.multiply(multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal multiplicand, int multiplier) {
        if (null == multiplicand)
            multiplicand = BigDecimal.ZERO;
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return multiplicand.multiply(_multiplier);
    }

    /**
     * 乘法
     *
     * @param multiplicand multiplicand
     * @param multiplier   multiplier
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal multiplicand,
                                      Integer multiplier) {
        if (null == multiplicand)
            multiplicand = BigDecimal.ZERO;
        if (null == multiplier)
            multiplier = 0;
        BigDecimal _multiplier = BigDecimal.valueOf(multiplier);
        return multiplicand.multiply(_multiplier);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(double dividend, double divisor) {
        BigDecimal _dividend = BigDecimal.valueOf(dividend);
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return _dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(int dividend, int divisor) {
        BigDecimal _dividend = BigDecimal.valueOf(dividend);
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return _dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(long dividend, long divisor) {
        BigDecimal _dividend = BigDecimal.valueOf(dividend);
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return _dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(Integer dividend, Integer divisor) {
        if (null == dividend)
            dividend = 0;
        if (null == divisor)
            divisor = 0;
        BigDecimal _dividend = BigDecimal.valueOf(dividend);
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return _dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
        if (null == dividend)
            dividend = BigDecimal.ZERO;
        if (null == divisor)
            divisor = BigDecimal.ZERO;
        return dividend.divide(divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(BigDecimal dividend, int divisor) {
        if (null == dividend)
            dividend = BigDecimal.ZERO;
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 除法
     *
     * @param dividend dividend
     * @param divisor  divisor
     * @return BigDecimal
     */
    public static BigDecimal divide(BigDecimal dividend, Integer divisor) {
        if (null == dividend)
            dividend = BigDecimal.ZERO;
        if (null == divisor)
            divisor = 0;
        BigDecimal _divisor = BigDecimal.valueOf(divisor);
        return dividend.divide(_divisor, MathContext.DECIMAL128);
    }

    /**
     * 截取2位小数
     *
     * @param b b
     * @return BigDecimal
     */
    public static BigDecimal getTowBitBigDecimal(BigDecimal b) {
        return b.setScale(2, BigDecimal.ROUND_DOWN);
    }

}