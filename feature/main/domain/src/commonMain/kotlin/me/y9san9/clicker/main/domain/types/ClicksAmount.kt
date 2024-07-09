package me.y9san9.clicker.main.domain.types

@JvmInline
value class ClicksAmount(val int: Int) {
    operator fun plus(amount: IncreaseAmount): ClicksAmount {
        return ClicksAmount(int = int + amount.int)
    }

    operator fun plus(amount: ClicksAmount): ClicksAmount {
        return ClicksAmount(int = int + amount.int)
    }

    companion object {
        val Zero = ClicksAmount(0)
    }
}
