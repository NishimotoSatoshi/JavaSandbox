package jp.co.opst.s029817.sandbox.for_secure_visitor.core;

import java.util.Optional;
import java.util.function.BiPredicate;

import lombok.RequiredArgsConstructor;

/**
 * 値を参照するために権限が必要となるコンテナ。
 * 
 * @param <T> 保持している値の型
 * @param <C> 保持している値を取得するために必要となる権限の型
 */
@RequiredArgsConstructor
public final class Strongbox<T, C> {

	/** 保持している値。 */
	private final T value;

	/** 保持している値が取得できる権限を持っているかを確認する関数。 */
	private final BiPredicate<T, C> unlockable;

	/**
	 * 保持している値を取得します。
	 * 
	 * @param credentials 参照に必要な権限
	 * @return 保持している値（取得に必要な権限を持っていない場合はエンプティ）
	 */
	public Optional<T> unlock(C credentials) {
		return Optional.ofNullable(value).filter(v -> unlockable.test(v, credentials));
	}
}
