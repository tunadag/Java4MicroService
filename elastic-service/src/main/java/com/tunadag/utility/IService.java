package com.tunadag.utility;

import java.util.List;
import java.util.Optional;

/**
 * Servis Sözleşmesi, burada kalıp olarak oluşturulan methodlar
 * tüm servislerde aynısıyla kullanılmak zorundadır.
 * SORUNLAR;
 * 1- Eğer buradaki methodlar tüm servisler tarafından kullanılcak ise,
 * kaydetme işleminde hangi entity adı yazılmalı???
 * Çözüm: Type olarak belirsiz durumlarda, Object gibi katı türleri kullanmak yerine
 * esnek bir şablon çıkarmak doğru olacaktır. Bunu yapabilmek için, Generic Type ile çözülür.
 * 2- Peki, id her zaman long olamaz, String veya Integer da olabilir, o zaman Long kullanmak sorun yaratacaktır.
 */

public interface IService<T, ID> {
    T save(T t);
    Iterable<T> saveAll(Iterable<T> t);
    T update(T t);
    void delete(T t);
    void deleteById(ID id);
    Iterable<T> findAll();
    Optional<T> findById(ID id);
}
